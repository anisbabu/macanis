import { useState, useEffect } from 'react';

function CompanyImages({ companyCode }) {
  const [logoUrl, setLogoUrl] = useState(null);
  const [iconUrl, setIconUrl] = useState(null);
  const [bgUrl, setBgUrl] = useState(null);

  useEffect(() => {
    async function fetchImages() {
      try {
        const logoRes = await fetch(`/images/${companyCode}/logo/logo.png`); // Replace logo.png
        if (logoRes.ok) {
          setLogoUrl(`/images/${companyCode}/logo/logo.png`);
        }
        const iconRes = await fetch(`/images/${companyCode}/icon/icon.png`); // Replace icon.png
        if (iconRes.ok) {
          setIconUrl(`/images/${companyCode}/icon/icon.png`);
        }
        const bgRes = await fetch(`/images/${companyCode}/bg/bg.jpg`); // Replace bg.jpg
        if (bgRes.ok) {
          setBgUrl(`/images/${companyCode}/bg/bg.jpg`);
        }
      } catch (error) {
        console.error('Error fetching images:', error);
      }
    }

    fetchImages();
  }, [companyCode]);

  return (
    <div>
      {logoUrl && <img src={logoUrl} alt="Company Logo" />}
      {iconUrl && <img src={iconUrl} alt="Company Icon" />}
      {bgUrl && <img src={bgUrl} alt="Company Background" />}
    </div>
  );
}

export default CompanyImages;